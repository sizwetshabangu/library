import { Inject, Injectable } from '@nestjs/common';
import { CreateCategoryDto } from './dto/create-category.dto';
import { UpdateCategoryDto } from './dto/update-category.dto';
import { CATEGORY_REPOSITORY } from 'src/common/constants';
import { Repository } from 'typeorm';
import { Category } from './entities/category.entity';
import { UUID } from 'crypto';

@Injectable()
export class CategoryService {
  constructor(@Inject(CATEGORY_REPOSITORY) private categoryRepository: Repository<Category>) { }

  create(createCategoryDto: CreateCategoryDto) {
    return this.categoryRepository.save(createCategoryDto);
  }

  findAll() {
    return this.categoryRepository.find();
  }

  findOne(id: UUID) {
    return this.categoryRepository.findOneBy({ id });
  }

  update(id: UUID, updateCategoryDto: UpdateCategoryDto) {
    return this.categoryRepository.update(id, updateCategoryDto);
  }

  remove(id: UUID) {
    return this.categoryRepository.delete(id);
  }
}
