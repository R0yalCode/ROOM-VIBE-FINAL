package edu.unl.cc.jbrew.bussiness.services;

import edu.unl.cc.jbrew.domain.security.Role;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Named("roleRepository")
@Stateless
public class RoleRepository {

    private static final Map<String, Role> tableRoleBD;

    static {
        tableRoleBD = new TreeMap<>();

        // Roles base
        tableRoleBD.put("ADMIN", new Role(1L, "ADMIN"));
        tableRoleBD.put("CAJERO", new Role(2L, "CAJERO"));
        tableRoleBD.put("RECEPCIONISTA", new Role(3L, "RECEPCIONISTA"));

        for (Map.Entry<String, Role> entry : tableRoleBD.entrySet()) {
            Role role = entry.getValue();

            role.add(PermissionRepository.find(1L));
            role.add(PermissionRepository.find(2L));
            role.add(PermissionRepository.find(3L));
            role.add(PermissionRepository.find(4L));
            role.add(PermissionRepository.find(5L));
            role.add(PermissionRepository.find(6L));
            role.add(PermissionRepository.find(7L));
            role.add(PermissionRepository.find(8L));
        }
    }

    public Set<Role> findAllWithPermissions() {
        return Set.copyOf(tableRoleBD.values());
    }

    public Role find(String name) {
        return tableRoleBD.get(name);
    }
}
