package book.bookReview;

//Класс для записи и вывода данных
class Music {
    private String name, description, author, image;

    Music(String name, String description, String author, String image) {
        super();
        this.name = name;
        this.description = description;
        this.author = author;
        this.image = image;
    }

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    String getAuthor() {
        return this.author;
    }

    String getImage() {
        return this.image;
    }

}
