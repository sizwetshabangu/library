export class Book {
    constructor(
        private id: string,
        private isbn: string,
        private category: string,
        private title: string,
        private author: string,
        private language: string,
        private publicationYear: number,
        private publisher: string,
        private image: string,
        private isAvailable: boolean,
        private createdAt: Date,
        private updatedAt: Date,
        private deletedAt: Date,
        private deleted: boolean,
        private deletedBy: string,
        private updatedBy: string,
        private createdBy: string,
    ) { }
}
