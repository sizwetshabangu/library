import { UUID } from "crypto";
import e from "express";
import { Book } from "../entities/book.entity";

export class BookDto {
    private id: UUID;
    private isbn: string;
    private category: string;
    private title: string;
    private author: string;
    private language: string;
    private publicationYear: number;
    private publisher: string;
    private image: string;

    constructor(book: Book) {
        this.id = book.id;
        this.isbn = book.isbn;
        this.category = book.category;
        this.title = book.title;
        this.author = book.author;
        this.language = book.language;
        this.publicationYear = book.publicationYear;
        this.publisher = book.publisher;
        this.image = book.image;
    }
}