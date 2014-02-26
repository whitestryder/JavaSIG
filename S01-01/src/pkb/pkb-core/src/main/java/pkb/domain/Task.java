/*
 * Classname : Task
 * Project   : pkb-core
 * Version   : $Id$ 
 * Purpose   : 
 * 
 * Copyright (c) 2004-2014, MDA, All Rights Reserved
 * 
 * Author    Date        Issue#   Comments
 * --------- ----------- -------- -----------------------------------
 * 
 */

package pkb.domain;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;


/**
 * @author JVANS
 * 
 */
public class Task {

  private String _name;

  /**
   * @param name
   */
  public Task(String name) {
    super();
    setName(name);
  }

  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }

  /**
   * @param name
   *          the name to set
   */
  private void setName(String name) {
    checkArgument(!Strings.isNullOrEmpty(name), "name is required");
    _name = name;
  }

}
