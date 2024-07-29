document.addEventListener('DOMContentLoaded', () => {
    const fetchNewsButton = document.getElementById('fetch-news');
    const newsContainer = document.getElementById('news-container');

    fetchNewsButton.addEventListener('click', () => {
        fetch('/api/news')
            .then(response => response.json())
            .then(data => {
                newsContainer.innerHTML = '';
                data.forEach(article => {
                    const articleElement = document.createElement('article');
                    articleElement.innerHTML = `
                        <h2>${article.title}</h2>
                        <p>${article.description}</p>
                        <a href="${article.url}" target="_blank">Read more</a>
                    `;
                    newsContainer.appendChild(articleElement);
                });
            })
            .catch(error => console.error('Error fetching news:', error));
    });
});
