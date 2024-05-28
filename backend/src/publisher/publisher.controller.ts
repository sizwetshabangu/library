import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { PublisherService } from './publisher.service';
import { CreatePublisherDto } from './dto/create-publisher.dto';
import { UpdatePublisherDto } from './dto/update-publisher.dto';
import { PublisherDto } from './dto/publisher.dto';
import { UUID } from 'crypto';

@Controller('publisher')
export class PublisherController {
  constructor(private readonly publisherService: PublisherService) { }

  @Post()
  create(@Body() createPublisherDto: CreatePublisherDto) {
    return this.publisherService.create(createPublisherDto);
  }

  @Get()
  findAll() {
    return this.publisherService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: UUID) {
    return this.publisherService.findOne(id);
  }

  @Patch(':id')
  update(@Param('id') id: UUID, @Body() updatePublisherDto: UpdatePublisherDto) {
    return this.publisherService.update(id, updatePublisherDto);
  }

  @Delete(':id')
  remove(@Param('id') id: UUID) {
    return this.publisherService.remove(id);
  }
}
