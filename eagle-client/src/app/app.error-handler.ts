import { Observable } from 'rxjs/Observable';
import { Response } from '@angular/http'

export class ErrorHandler {
    static handleError(error: Response | any) {
        console.log(error)
        let errorMessage: string
        if (error instanceof Response) {
            errorMessage = `Erro ${error.status} ao obter a URL ${error.url} - ${error.statusText}`
        } else {
            errorMessage = error.toString();
        }
        console.log(errorMessage)
        return Observable.throw(errorMessage)
    }
}