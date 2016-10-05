export class Page {
    id: number;
    title: string;
    content?: string;
    isPublished: boolean;
    subPages?: Page[];
}