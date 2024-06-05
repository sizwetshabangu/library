import { Logger, Module } from '@nestjs/common';
import { BookService } from './book.service';
import { BookController } from './book.controller';
import { Book } from './entities/book.entity';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [TypeOrmModule.forFeature([Book]),],
  controllers: [BookController],
  providers: [BookService, Logger],
})
export class BookModule { }
