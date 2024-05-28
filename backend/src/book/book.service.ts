import { Inject, Injectable, Logger } from '@nestjs/common';
import { CreateBookDto } from './dto/create-book.dto';
import { UpdateBookDto } from './dto/update-book.dto';
import { DeleteResult, Repository, TypeORMError } from 'typeorm';
import { Book } from './entities/book.entity';
import { BOOK_REPOSITORY } from './../shared/constants';
import { UUID } from 'crypto';

@Injectable()
export class BookService {
  constructor(@Inject(BOOK_REPOSITORY) private bookRepository: Repository<Book>, private Logger: Logger) { }
  create(createBookDto: CreateBookDto) {
    Logger.log('Creating book', 'BookService.create');
    return this.bookRepository.save(createBookDto);
  }

  async findAll() {
    Logger.log('Finding all books', 'BookService.findAll');
    return await this.bookRepository.find();
  }

  async findOne(id: UUID): Promise<Book | null> {
    Logger.log(`Finding book with id: ${id}`, 'BookService.findOne');
    return await this.bookRepository.findOneBy({ id });
  }

  update(id: UUID, updateBookDto: UpdateBookDto) {
    Logger.log(`Updating book with id: ${id}`, 'BookService.update');
    return this.bookRepository.update(id, updateBookDto)
  }

  async remove(id: UUID): Promise<DeleteResult> {
    Logger.log(`Deleting book with id: ${id}`, 'BookService.remove');
    return await this.bookRepository.delete(id);
  }
}
