import { DataSource } from 'typeorm';
import { PUBLISHER_REPOSITORY, DATA_SOURCE } from 'src/common/constants';
import { Publisher } from './entities/publisher.entity';

export const publisherRepository = [
    {
        provide: PUBLISHER_REPOSITORY,
        useFactory: (dataSource: DataSource) => dataSource.getRepository(Publisher),
        inject: [DATA_SOURCE],
    },
];