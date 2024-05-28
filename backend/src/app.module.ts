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
import { from } from 'rxjs';
import { TypeOrmModule } from '@nestjs/typeorm';
import { DataSource } from 'typeorm';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'backend-application',
      password: 'U3Edk6SHxd0pbSS',
      database: 'library',
      synchronize: true,
      autoLoadEntities: true,
    }),
    ConfigModule.forRoot({
      load: [
        databaseConfig,
      ]
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
