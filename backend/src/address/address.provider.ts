import { DataSource } from 'typeorm';
import { Address } from './entities/address.entity';
import { ADDRESS_REPOSITORY, DATA_SOURCE } from 'src/shared/constants';

export const addressProvider = [
    {
        provide: ADDRESS_REPOSITORY,
        useFactory: (dataSource: DataSource) => dataSource.getRepository(Address),
        inject: [DATA_SOURCE],
    },
];