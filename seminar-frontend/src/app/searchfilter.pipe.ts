import { Pipe, PipeTransform } from '@angular/core';
import { Detail } from './detail';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(items: any[], filterQuery: any): any[] {
    if(!filterQuery){
      return items;
    }
    return items.filter((item) => 
      item.id.toLowerCase().includes(filterQuery.toLowerCase())
    );
  }

}
