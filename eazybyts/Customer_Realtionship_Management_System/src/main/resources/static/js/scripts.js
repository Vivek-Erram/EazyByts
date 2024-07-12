document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('contact-form');
    const contactsList = document.getElementById('contacts-list');

    contactForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const name = contactForm.name.value;
        const email = contactForm.email.value;

        // Mock API call to add contact
        contactsList.innerHTML += `<div>${name} - ${email}</div>`;

        contactForm.reset();
    });

    const salesForm = document.getElementById('sales-form');
    const salesList = document.getElementById('sales-list');

    salesForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const deal = salesForm.deal.value;
        const amount = salesForm.amount.value;

        // Mock API call to add deal
        salesList.innerHTML += `<div>${deal} - $${amount}</div>`;

        salesForm.reset();
    });

    const taskForm = document.getElementById('task-form');
    const tasksList = document.getElementById('tasks-list');

    taskForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const task = taskForm.task.value;
        const deadline = taskForm.deadline.value;

        // Mock API call to add task
        tasksList.innerHTML += `<div>${task} - ${deadline}</div>`;

        taskForm.reset();
    });

    const supportForm = document.getElementById('support-form');
    const supportTicketsList = document.getElementById('support-tickets-list');

    supportForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const issue = supportForm.issue.value;

        // Mock API call to submit support ticket
        supportTicketsList.innerHTML += `<div>${issue}</div>`;

        supportForm.reset();
    });
});
