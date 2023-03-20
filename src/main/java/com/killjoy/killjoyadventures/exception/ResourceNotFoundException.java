package com.killjoy.killjoyadventures.exception;

public class ResourceNotFoundException extends RuntimeException {

  private final String resourceType;
  private final String resourceId;

  public ResourceNotFoundException(String resourceType, String resourceId) {
    super(String.format("%s with ID %s not found", resourceType, resourceId));
    this.resourceType = resourceType;
    this.resourceId = resourceId;
  }

  public String getResourceType() {
    return resourceType;
  }

  public String getResourceId() {
    return resourceId;
  }
}