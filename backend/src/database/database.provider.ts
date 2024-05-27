import { env } from 'process';
import { DataSource } from 'typeorm';

export const databaseProvider = [
    {
        provide: 'DATA_SOURCE',
        useFactory: async () => {
            const dataSource = new DataSource({
                type: 'mysql',
                host: 'localhost',
                port: 3306,
                username: 'backend-application',
                password: 'U3Edk6SHxd0pbSS',
                database: 'library',
                entities: [
                    __dirname + '/../**/*.entity{.ts,.js}',
                ],
                synchronize: true,

            });

            return dataSource.initialize();
        },
    },
];