import { Logger, Module } from '@nestjs/common';
import { BookService } from './book.service';
import { BookController } from './book.controller';
import { bookProvider } from './book.provider';
import { DatabaseModule } from 'src/database/database.module';

@Module({
  imports: [DatabaseModule,],
  controllers: [BookController],
  providers: [...bookProvider, BookService, Logger],
})
export class BookModule { }
