package bank.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements UserDetails {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerStatus;
    private long contact;
    private String username;
    private String password;
    private int attempts;
    private long customerAadhaar;
    private String customerPan;
    private String updateStatus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
