hibernate
=========

This is Hibernate 4.2.2 final with MySQL Driver example

The examples include:

1. MappedSuperClass (done)

2. EventListener (done)

3. Joda time to MySQL datetime (done)

4. Enum mapping to MySQL int 



To Do

There is still no way to run @PrePersist @PreUpdate. Need further investigation to it. 

Also, have to find out 

1. the difference between persist, save, saveOrUpdate.
2. It seems that PrePersist/PreUpdate is run after saveOrUpdate. Why?
3.  need to find out how hibernate envor works


Fin,

Hope this one could help other beginners.