import { Logger, Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { BookModule } from './book/book.module';
import { PublisherModule } from './publisher/publisher.module';
import { CategoryModule } from './category/category.module';
import { AddressModule } from './address/address.module';
import { ReaderModule } from './reader/reader.module';
import { StaffModule } from './staff/staff.module';
import { ConfigModule } from '@nestjs/config';
import databaseConfig from './config/database/database.config';
import { TypeOrmModule } from '@nestjs/typeorm';
import { DataSource } from 'typeorm';

@Module({
  imports: [
    ConfigModule.forRoot({
      load: [databaseConfig],
      envFilePath: ['development.local.env'],
    }),
    TypeOrmModule.forRoot({
      type: process.env.MYSQL_DATABASE_TYPE as "mysql",
      host: process.env.MYSQL_HOST,
      port: parseInt(process.env.MYSQL_PORT ?? '3306'),
      username: process.env.MYSQL_USER,
      password: process.env.MYSQL_PASSWORD,
      database: process.env.MYSQL_DATABASE,
      entities: ['dist/**/*.entity{.ts,.js}'],
      synchronize: process.env.TYPEORM_SYNCHRONIZE === 'true',
      connectTimeout: 30000,
      retryAttempts: 3,
      retryDelay: 3000,
      keepConnectionAlive: true,
      timezone: '+02:00',
    }),
    BookModule,
    PublisherModule,
    CategoryModule,
    AddressModule,
    ReaderModule,
    StaffModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {
  constructor(private dataSource: DataSource) { }
}
