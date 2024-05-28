import { Controller, Get, Post, Body, Patch, Param, Delete, Logger } from '@nestjs/common';
import { BookService } from './book.service';
import { CreateBookDto } from './dto/create-book.dto';
import { UpdateBookDto } from './dto/update-book.dto';
import { UUID } from 'crypto';
import { BookDto } from './dto/book.dto';

@Controller('book')
export class BookController {
  constructor(private readonly bookService: BookService, private Logger: Logger) { }

  @Post()
  create(@Body() createBookDto: CreateBookDto) {
    Logger.log('Creating book', 'BookController.create');
    return this.bookService.create(createBookDto);
  }

  @Get()
  findAll() {
    Logger.log('Finding all books', 'BookController.findAll');
    return this.bookService.findAll();
  }

  @Get(':id')
  async findOne(@Param('id') id: UUID) {
    Logger.log(`Finding book with id: ${id}`, 'BookController.findOne');
    return await this.bookService.findOne(id);
  }

  @Patch(':id')
  update(@Param('id') id: UUID, @Body() updateBookDto: UpdateBookDto) {
    Logger.log(`Updating book with id: ${id}`, 'BookController.update');
    return this.bookService.update(id, updateBookDto);
  }

  @Delete(':id')
  remove(@Param('id') id: UUID) {
    Logger.log(`Deleting book with id: ${id}`, 'BookController.remove');
    return this.bookService.remove(id);
  }
}
