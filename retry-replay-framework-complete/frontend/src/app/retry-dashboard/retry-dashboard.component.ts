import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-retry-dashboard',
  template: `
    <h2>Retry Dashboard</h2>
    <ul>
      <li *ngFor="let txn of transactions">
        {{txn.id}} - {{txn.status}} 
        <button (click)="retry(txn.id)">Retry</button>
      </li>
    </ul>
  `
})
export class RetryDashboardComponent {
  transactions: any[] = [];

  constructor(private http: HttpClient) {
    this.loadTransactions();
  }

  loadTransactions() {
    this.http.get('/api/transactions').subscribe((data: any) => this.transactions = data);
  }

  retry(id: string) {
    this.http.post('/api/retry/' + id, {}).subscribe(() => this.loadTransactions());
  }
}