package com.luv2code.springmvcsecurity.demosecurity.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WebUser
{
    @NotNull(message = "*required field")
    @Size(min=1, message = "*required field")
    private String userName;

    @NotNull(message = "*required field")
    @Size(min=1, message = "*required field")
    private String password;

    public @NotNull(message = "*required field") @Size(min = 1, message = "*required field") String getUserName()
    {
        return userName;
    }

    public void setUserName(@NotNull(message = "*required field") @Size(min = 1, message = "*required field") String userName)
    {
        this.userName = userName;
    }

    public @NotNull(message = "*required field") @Size(min = 1, message = "*required field") String getPassword()
    {
        return password;
    }

    public void setPassword(@NotNull(message = "*required field") @Size(min = 1, message = "*required field") String password)
    {
        this.password = password;
    }
}
