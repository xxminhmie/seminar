export class Detail {
    id!: string;
    bookId: string | undefined;
    returnedDate: string | undefined;
    status : string | undefined;
    note: string | undefined;
    borrow: Borrow | undefined;    
}

export class Borrow {
    id!: number;
    cardId: string | undefined;
    borrowDate: string | undefined;

}