package com.github.jmchilton.blend4j.galaxy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.jmchilton.blend4j.galaxy.beans.Role;

import java.util.List;

class RolesClientImpl extends ClientImpl implements RolesClient {
  private static final TypeReference<List<Role>> ROLE_LIST_TYPE_REFERENCE = new TypeReference<List<Role>>() {
  };
  
  RolesClientImpl(GalaxyInstanceImpl galaxyInstance) {
    super(galaxyInstance, "roles");
  }

  public List<Role> getRoles() {
    return super.get(ROLE_LIST_TYPE_REFERENCE);
  }
  
  public Role getRole(final String name) {
    Role matchingRole = null;
    for(final Role role : getRoles()) {
      if(role.getName().equals(name)) {
        matchingRole = role;         
      }
    }
    return matchingRole;
  }

}
