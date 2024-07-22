// scripts.js

document.addEventListener("DOMContentLoaded", function() {
    // Initialize the trading page elements and event listeners
    initTradingPage();

    // Initialize the portfolio page elements and event listeners
    initPortfolioPage();

    // Initialize the performance page elements and event listeners
    initPerformancePage();
});

function initTradingPage() {
    const tradingPage = document.querySelector('title').innerText === 'Trading';
    if (tradingPage) {
        const tradeForm = document.getElementById('tradeForm');
        tradeForm.addEventListener('submit', function(event) {
            event.preventDefault();
            // Handle trade form submission
            const stockSymbol = document.getElementById('stockSymbol').value;
            const quantity = document.getElementById('quantity').value;
            const price = document.getElementById('price').value;
            const userId = document.getElementById('userId').value;

            const tradeData = {
                stockSymbol: stockSymbol,
                quantity: quantity,
                price: price,
                user: { id: userId }
            };

            fetch('/api/trades', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(tradeData)
            })
            .then(response => response.json())
            .then(data => {
                alert('Trade successful');
                // Optionally, update the UI with the new trade
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    }
}

function initPortfolioPage() {
    const portfolioPage = document.querySelector('title').innerText === 'Portfolio';
    if (portfolioPage) {
        // Fetch and display user's portfolio
        const userId = document.getElementById('userId').value;

        fetch(`/api/portfolio?userId=${userId}`)
        .then(response => response.json())
        .then(data => {
            const portfolioContainer = document.getElementById('portfolioContainer');
            data.forEach(item => {
                const portfolioItem = document.createElement('div');
                portfolioItem.innerHTML = `
                    <p>Stock: ${item.stockSymbol}</p>
                    <p>Quantity: ${item.quantity}</p>
                    <p>Average Price: ${item.averagePrice}</p>
                `;
                portfolioContainer.appendChild(portfolioItem);
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
}

function initPerformancePage() {
    const performancePage = document.querySelector('title').innerText === 'Performance';
    if (performancePage) {
        // Fetch and display user's performance
        const userId = document.getElementById('userId').value;

        fetch(`/api/performance?userId=${userId}`)
        .then(response => response.json())
        .then(data => {
            const performanceContainer = document.getElementById('performanceContainer');
            data.forEach(item => {
                const performanceItem = document.createElement('div');
                performanceItem.innerHTML = `
                    <p>Stock: ${item.stockSymbol}</p>
                    <p>Profit/Loss: ${item.profitLoss}</p>
                `;
                performanceContainer.appendChild(performanceItem);
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
}
