package com.example.library.services;

import com.example.library.dto.request.BookCreateDTO;
import com.example.library.dto.response.BookGetResponseDTO;
import com.example.library.entities.Book;
import com.example.library.entities.Category;
import com.example.library.entities.PublishingHouse;
import com.example.library.entities.Writer;
import com.example.library.repossitory.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final WriterService writerService;
    private final CategoryService categoryService;
    private final PublishingHouseService pbService;
    private final ModelMapper mapper;

    public BookService(BookRepository bookRepository, WriterService writerService,CategoryService categoryService, PublishingHouseService pbService, ModelMapper mapper){
        this.bookRepository = bookRepository;
        this.writerService = writerService;
        this.categoryService = categoryService;
        this.pbService = pbService;
        this.mapper = mapper;
    }

    /*
    kitap eklerken BookCreateDTO türünde bir nesne alıyoruz bu aldığımız nesne ile birlikte
    kitap nesnesi için gerekli olan alanların olup olmadığını mesela (yazar ve yayınevi) kontrol ettikten
    kitap nesnesi oluşturulup veritabanına kaydedilir.
     */
    public Book addBook(BookCreateDTO createDTO){
        Optional<Writer> foundWriter = Optional.ofNullable(writerService.getWriterAllFieldById(createDTO.writerId));
        Optional<PublishingHouse> foundPbHouse = Optional.ofNullable(pbService.getPbHouseAllFieldById(createDTO.pbHouseId));
        List<Category> categories = categoryParse(createDTO.categoryList);

        if (!(categories.isEmpty()) && foundWriter.isPresent() && foundPbHouse.isPresent() ){
            Book newBook = mapper.map(createDTO,Book.class);
            newBook.setPublishingHouse(foundPbHouse.get());
            return bookRepository.save(newBook);
        }else {
            return null;
        }
    }

    /*
    Bu metodun kulllanım amacı book post isteği aldığımızda gelen kategori id'leri ile
    veri tabanından kategorileri getirip geriye kategorilerin olduğu bir liste döndermek bu sayede
    book nesnesini oluşturmak için gerekli olan category list'ini almış oluyoruz.
     */
    private List<Category> categoryParse(List<Category> categoryList) {
        List<Category> categories = new ArrayList<>();
        categoryList.forEach(item -> {
            Optional<Category> foundCategory = Optional.ofNullable(categoryService.getCategoryAllFieldById(item.getId()));
            if (foundCategory.isPresent()){
                categories.add(foundCategory.get());
            }
        });
        return categories;
    }

    // bütün kitaplar getirme
    public List<BookGetResponseDTO> getAllBook(){
        List<Book> books = bookRepository.findAll();
        List<BookGetResponseDTO> responseDTO = new ArrayList<>();

        books.forEach(book -> {
            responseDTO.add(mapper.map(book,BookGetResponseDTO.class));
        });
        return responseDTO;

    }

//    public List<Book> getWriterBooks(Long id){
//
//    }

    // girilen id bilgisine göre kitap getirme
    public Book getBookById(Long id){
        Optional<Book> foundBook = bookRepository.findById(id);
        if (foundBook.isPresent()){
            return foundBook.get();
        }else {
            return null;
        }
    }

    // kitap silme
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}
