package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.AccountsRepo;
import com.eazybytes.accounts.repository.CustomerRepo;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class IAccountServiceImpl implements IAccountsService {


    private AccountsRepo accountsRepo;

    private CustomerRepo customerRepo;
    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer= CustomerMapper.mapToCustomer(customerDto ,new Customer());

        Customer savedCustomer= customerRepo.save(customer);

        accountsRepo.save(CreateNewAccount(savedCustomer));

    }



    private Accounts CreateNewAccount (Customer customer){

        Accounts newAccount =new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());

        long randomAccNumber =1000000000l +new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
