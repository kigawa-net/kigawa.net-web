package net.kigawa.kweb.repository;

import net.kigawa.kweb.entity.AdminUser;
import org.springframework.data.repository.CrudRepository;

public interface AdminUserRepository extends CrudRepository<AdminUser,Long>
{
}
