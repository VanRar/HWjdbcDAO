select netology.orders.product_name
from netology.orders
         inner join netology.customers c on netology.orders.customer_id = c.id
where lower(c.name) = ?;