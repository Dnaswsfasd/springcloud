package com.ddfree.feign;

import com.ddfree.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value="provider")
public interface FeignProviderClient {

    @GetMapping("/findAll")
    public Collection<Student> findAll();

    @GetMapping("/index")
    public String index();
}
