import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ReaderService } from './reader.service';
import { CreateReaderDto } from './dto/create-reader.dto';
import { UpdateReaderDto } from './dto/update-reader.dto';
import { UUID } from 'crypto';

@Controller('reader')
export class ReaderController {
  constructor(private readonly readerService: ReaderService) { }

  @Post()
  create(@Body() createReaderDto: CreateReaderDto) {
    return this.readerService.create(createReaderDto);
  }

  @Get()
  findAll() {
    return this.readerService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: UUID) {
    return this.readerService.findOne(id);
  }

  @Patch(':id')
  update(@Param('id') id: UUID, @Body() updateReaderDto: UpdateReaderDto) {
    return this.readerService.update(id, updateReaderDto);
  }

  @Delete(':id')
  remove(@Param('id') id: UUID) {
    return this.readerService.remove(id);
  }
}
