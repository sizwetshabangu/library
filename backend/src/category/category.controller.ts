import { Controller, Get, Post, Body, Patch, Param, Delete, Response, Res, NotFoundException, HttpStatus, HttpCode } from '@nestjs/common';
import { CategoryService } from './category.service';
import { CreateCategoryDto } from './dto/create-category.dto';
import { UpdateCategoryDto } from './dto/update-category.dto';
import { UUID } from 'crypto';
import { DeleteResult } from 'typeorm';
import { response } from 'express';
import { HttpErrorByCode } from '@nestjs/common/utils/http-error-by-code.util';

@Controller('category')
export class CategoryController {
  constructor(private readonly categoryService: CategoryService) { }

  @Post()
  create(@Body() createCategoryDto: CreateCategoryDto) {
    return this.categoryService.create(createCategoryDto);
  }

  @Get()
  findAll() {
    return this.categoryService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: UUID) {
    return this.categoryService.findOne(id);

  }

  @Patch(':id')
  update(@Param('id') id: UUID, @Body() updateCategoryDto: UpdateCategoryDto) {
    return this.categoryService.update(id, updateCategoryDto);
  }

  @Delete(':id')
  remove(@Param('id') id: UUID) {
    return this.categoryService.remove(id);
  }
}
