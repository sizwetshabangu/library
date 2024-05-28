import { DataSource } from 'typeorm';
import { DATA_SOURCE, READER_REPOSITORY } from 'src/shared/constants';
import { Reader } from './entities/reader.entity';

export const readerProvider = [
    {
        provide: READER_REPOSITORY,
        useFactory: (dataSource: DataSource) => dataSource.getRepository(Reader),
        inject: [DATA_SOURCE],
    },
];