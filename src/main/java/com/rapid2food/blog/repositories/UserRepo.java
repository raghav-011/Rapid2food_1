package com.rapid2food.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapid2food.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}

/*

1 JpaRepository mein 2 chiz btani hoti hai phle argument mein konse entities ka 
  sath kam krna hai ye btna hoga jaise hum User ka sath kr rahe hai
  
2 Second argumnet ki jo apane id lia hai vo konse type ki hai in our case it's a integer type 

JpaRepository hko sare function provide krdega database mein sbhi operation perform krne k lia
also ya extend krta hai pagingandsorting to iske function increase ho jate hai hum check kr skte hai
by using ctrl + click on repositories

*/