import { Logger, Module } from '@nestjs/common';
import { ReaderService } from './reader.service';
import { ReaderController } from './reader.controller';
import { DatabaseModule } from 'src/database/database.module';
import { readerProvider } from './reader.provider';

@Module({
  imports: [DatabaseModule],
  controllers: [ReaderController],
  providers: [...readerProvider, ReaderService, Logger],
})
export class ReaderModule { }
