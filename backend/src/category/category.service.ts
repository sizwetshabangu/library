import { Injectable, Logger, NotFoundException } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { UUID } from 'crypto';
import { Repository } from 'typeorm';
import { CreateCategoryDto } from './dto/create-category.dto';
import { UpdateCategoryDto } from './dto/update-category.dto';
import { Category } from './entities/category.entity';

@Injectable()
export class CategoryService {
  constructor(
    @InjectRepository(Category) private categoryRepository: Repository<Category>,
    private Logger: Logger,
  ) { }

  async create(createCategoryDto: CreateCategoryDto) {
    Logger.log('Creating category', 'CategoryService.create');
    return await this.categoryRepository.save(createCategoryDto);
  }

  async findAll() {
    Logger.log('Finding all categories', 'CategoryService.findAll');
    return await this.categoryRepository.find();
  }

  async findOne(id: UUID) {
    Logger.log(`Finding category with id: ${id}`, 'CategoryService.findOne');
    let result = await this.categoryRepository.findOneBy({ id });
    if (!result) {
      Logger.log(`Category with id: ${id} not found`, 'CategoryService.findOne');
      return new NotFoundException(`Category with id: ${id} not found`);
    }
    return result;
  }

  async update(id: UUID, updateCategoryDto: UpdateCategoryDto) {
    Logger.log(`Updating category with id: ${id}`, 'CategoryService.update');
    return await this.categoryRepository.update(id, updateCategoryDto);
  }

  async remove(id: UUID) {
    Logger.log(`Deleting category with id: ${id}`, 'CategoryService.remove');
    return await this.categoryRepository.delete(id);
  }
}
