/**********************************************************************/
select * from products where product_name like 'c%';

/**********************************************************************/
select * from products order by price limit 1;

/*I didn't understand exactly if I should find the price of each element from the USA 
  or find a total sum of products from the USA, so I wrote both query*/
select p.product_id, p.product_name, p.price, s.country 
from products p inner join suppliers s
on p.supplier_id = s.supplier_id
where country like 'usa';

select round(sum(p.price), 2), s.country 
from products p inner join suppliers s
on p.supplier_id = s.supplier_id
where country like 'usa';

/**********************************************************************/
select distinct p.supplier_id, s.supplier_name, s.city, s.country
from products p inner join suppliers s
on p.supplier_id = s.supplier_id
where p.category_id = (select category_id from categories where category_name like 'condiments');


/**********************************************************************/
start transaction;

INSERT INTO suppliers (supplier_name, city, country)
value ("Norske Meierier", "Lviv", "Ukraine");

select @supplier_id := supplier_id from suppliers where supplier_name like 'Norske Meierier';
select @category_id := category_id from categories where category_name like 'Beverages';

insert into products (product_name, supplier_id, category_id, price)
value ("Green tea", @supplier_id, @category_id, 10.0);

commit;



