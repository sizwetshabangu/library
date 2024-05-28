import { DataSource } from "typeorm";
import { Book } from "./entities/book.entity";
import { BOOK_REPOSITORY, DATA_SOURCE } from "src/common/constants";

export const bookProvider = [
    {
        provide: BOOK_REPOSITORY,
        useFactory: (dataSource: DataSource) => dataSource.getRepository(Book),
        inject: [DATA_SOURCE],
    },
];