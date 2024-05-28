import { DataSource } from "typeorm";
import { Category } from "./entities/category.entity";
import { CATEGORY_REPOSITORY, DATA_SOURCE } from "src/common/constants";

export const categoryProvider = [
    {
        provide: CATEGORY_REPOSITORY,
        useFactory: (dataSource: DataSource) => dataSource.getRepository(Category),
        inject: [DATA_SOURCE],
    },
];