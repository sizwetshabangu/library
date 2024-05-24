import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { BookModule } from './book/book.module';
import { PublisherModule } from './publisher/publisher.module';
import { CategoryModule } from './category/category.module';
import { AddressModule } from './address/address.module';
import { ReaderModule } from './reader/reader.module';
import { StaffModule } from './staff/staff.module';

@Module({
  imports: [BookModule, PublisherModule, CategoryModule, AddressModule, ReaderModule, StaffModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule { }
