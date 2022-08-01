package net.kigawa.kweb.database;

import net.kigawa.kweb.entity.AdminUser;
import net.kigawa.kweb.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner
{
    private final AdminUserRepository adminUserRepository;

    @Autowired
    public DatabaseLoader(AdminUserRepository adminUserRepository)
    {
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        adminUserRepository.save(new AdminUser("test"));
    }
}
