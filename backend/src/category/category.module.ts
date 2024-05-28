import { Logger, Module } from '@nestjs/common';
import { CategoryService } from './category.service';
import { CategoryController } from './category.controller';
import { DatabaseModule } from 'src/database/database.module';
import { categoryProvider } from './category.provider';

@Module({
  imports: [DatabaseModule,],
  controllers: [CategoryController],
  providers: [...categoryProvider, CategoryService, Logger],
})
export class CategoryModule { }
