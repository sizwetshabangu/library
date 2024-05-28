import { DataSource } from "typeorm";
import { DATA_SOURCE, STAFF_REPOSITORY } from "src/common/constants";
import { Staff } from "./entities/staff.entity";

export const staffProvider = [
    {
        provide: STAFF_REPOSITORY,
        useFactory: (dataSource: DataSource) => dataSource.getRepository(Staff),
        inject: [DATA_SOURCE],
    },
];