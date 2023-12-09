import * as fs from 'fs';

export class Input {

    public getLines(url: string): string[] {
        try {
            const file: string = fs.readFileSync(url, 'utf-8')
            return file.split("\n");
        } catch (e) {
            throw new Error(e)
        }
    }

    public getString(url: string): string {
        try {
            return fs.readFileSync(url, 'utf-8').trim();
        } catch (e) {
            throw new Error(e)
        }
    }
}