import { UUID } from "crypto";

export interface CreateBookDto {
    title: string,
    isbn: string,
    category: string,
    author: string,
    language: string,
    publicationYear: number,
    publisher: string,
    image: string,
}