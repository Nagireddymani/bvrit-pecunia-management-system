package com.capg.pbms.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.pbms.exception.InsufficientBalanceException;
import com.capg.pbms.exception.InvalidAccountNumberException;
import com.capg.pbms.model.AccountManagement;
import com.capg.pbms.model.Cheque;
import com.capg.pbms.model.Slip;
import com.capg.pbms.model.Transaction;
import com.capg.pbms.repository.IChequeRepository;
import com.capg.pbms.repository.ISlipRepository;
import com.capg.pbms.repository.ITransacionRepository;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Transaction Service Implementation Class

*******************************************************************************************************************************/
@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	ITransacionRepository transactionRepository;
	
	@Autowired
	IChequeRepository chequeRepository;
	
	@Autowired
	ISlipRepository slipRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Random random;
	
	String value="XXXXXXXXXXXXXXX";
	
	String getAccountUrl="http://localhost:8200/customer/getaccount/";
	
	String updateAccountUrl="http://localhost:8200/customer/updateaccount";
	
	
	/*******************************************************************************************************************************
	-Function Name            :     addChequeCredit
	-Input Parameters         :     Cheque Object,transaction Type(Credit),to Account Number
	-Return Type              :     Cheque Object
	-Throws                   :     InvalidAccountNumberException
	-Author                   :     N.ManikataReddy
	-Created/Modified Date    :     22-09-2020
	-Description              :     verifying account Number making transaction Using Cheque
	*******************************************************************************************************************************/
	@Override
	public Cheque creditUsingCheque(Cheque cheque, String transType, String toAccountNumber) {
		AccountManagement account=restTemplate.getForObject(getAccountUrl+cheque.getAccountNum(), AccountManagement.class);
		if(account!=null ) {
					if(account.getAccountBalance()>cheque.getAmount() && cheque.getAmount() > 0) 
					{
								
							AccountManagement toAccount=restTemplate.getForObject(getAccountUrl+toAccountNumber, AccountManagement.class);
							if(toAccount!=null)
							{	
									Double fromBalance=account.getAccountBalance()-cheque.getAmount();
									Double toBalance=toAccount.getAccountBalance()+cheque.getAmount();
									
									//From Account
									account.setAccountBalance(fromBalance);
									account.setLastUpdated(LocalDate.now());
									//To Account
									toAccount.setAccountBalance(toBalance);
									toAccount.setLastUpdated(LocalDate.now());
									
									// From Transaction Object
									Transaction fromTransaction=new Transaction();
									
									fromTransaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
									fromTransaction.setTransAccountId(cheque.getAccountNum());
									fromTransaction.setTransType("debit");
									fromTransaction.setTransAmount(cheque.getAmount());
									fromTransaction.setTransOption("cheque");
									fromTransaction.setTransDate(LocalDateTime.now());
									fromTransaction.setTransClosingBalnace(fromBalance);
									fromTransaction.setTransFrom(cheque.getAccountNum());
									fromTransaction.setTransTo(toAccountNumber);
									
						            Transaction toTransaction=new Transaction();
									
									toTransaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
									toTransaction.setTransAccountId(toAccountNumber);
									toTransaction.setTransType("credit");
									toTransaction.setTransAmount(cheque.getAmount());
									toTransaction.setTransOption("cheque");
									toTransaction.setTransDate(LocalDateTime.now());
									toTransaction.setTransClosingBalnace(toBalance);
									toTransaction.setTransFrom(cheque.getAccountNum());
									toTransaction.setTransTo(toAccountNumber);
									
									
									try {
										restTemplate.put(new URI(updateAccountUrl), account);
										restTemplate.put(new URI(updateAccountUrl), toAccount);
									} catch (RestClientException e) {
										e.printStackTrace();
									} catch (URISyntaxException e) {
										e.printStackTrace();
									}
									
									transactionRepository.save(fromTransaction);
									transactionRepository.save(toTransaction);
									cheque.setChequeId(Integer.toString(random.nextInt(1000000)).substring(0,4));
									cheque.setChequeStatus("Issued");
									chequeRepository.save(cheque);
						    }
							else {
								throw new InvalidAccountNumberException("Invalid Account Number");
							}
					}
					else {
						throw new InsufficientBalanceException("Balance in Account is to low");
					}			
		}
		else {
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		
		return cheque;
	}
	

	/*******************************************************************************************************************************
	-Function Name            :     addChequeDebit
	-Input Parameters         :     Cheque Object,transaction Type(Credit)
	-Return Type              :     Cheque Object
	-Throws                   :     InvalidAccountNumberException
	-Author                   :     N.ManikataReddy
	-Created/Modified Date    :     22-09-2020
	-Description              :     verifying account Number making transaction Using Cheque
	*******************************************************************************************************************************/
	@Override
	public Cheque debitUsingCheque(Cheque cheque, String transType){
		AccountManagement account=restTemplate.getForObject(getAccountUrl+cheque.getAccountNum(), AccountManagement.class);
		if(account!=null) {
				if(account.getAccountBalance()>cheque.getAmount() && cheque.getAmount() > 0) 
				{	 
						Double balance=account.getAccountBalance()-cheque.getAmount();
						
						account.setAccountBalance(balance);
						account.setLastUpdated(LocalDate.now());
						try {
							restTemplate.put(new URI(updateAccountUrl), account);
						} catch (RestClientException e) {
							e.printStackTrace();
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
						Transaction transaction=new Transaction();
						
						transaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
						transaction.setTransAccountId(cheque.getAccountNum());
						transaction.setTransType("debit");
						transaction.setTransAmount(cheque.getAmount());
						transaction.setTransOption("cheque");
						transaction.setTransDate(LocalDateTime.now());
						transaction.setTransClosingBalnace(balance);
						transaction.setTransFrom(cheque.getAccountNum());
						transaction.setTransTo(value);
						
						transactionRepository.save(transaction);
						cheque.setChequeId(Integer.toString(random.nextInt(1000000)).substring(0,4));
						cheque.setChequeStatus("Issued");
						chequeRepository.save(cheque);
				}
				else
				{
					throw new InsufficientBalanceException("Balance in Account is to low");
				}
		}
		else {
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		return cheque;
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     addSlip
	-Input Parameters         :     Slip Object,transaction Type(Credit/Debit)
	-Return Type              :     Slip Object
	-Throws                   :     InvalidAccountNumberException
	-Author                   :     M.Sai
	-Created/Modified Date    :     22-09-2020
	-Description              :     verifying account Number making transaction Using Slip
	*******************************************************************************************************************************/
	@Override
	public Slip creditAndDebitUsingSlip(Slip slip, String transType) {
		AccountManagement account=restTemplate.getForObject(getAccountUrl+slip.getAccountNum(), AccountManagement.class);
		if(account!=null) 
		{
				if(transType.equals("credit"))
				{
					if(slip.getAmount() > 0)
					{
						Double balance=account.getAccountBalance()+slip.getAmount();
					    account.setAccountBalance(balance);	
					    account.setLastUpdated(LocalDate.now());
					    try {
							restTemplate.put(new URI(updateAccountUrl), account);
						} catch (RestClientException e) {
							e.printStackTrace();
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}
						
			            Transaction transaction=new Transaction();
						
						transaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
						transaction.setTransAccountId(slip.getAccountNum());
						transaction.setTransType("credit");
						transaction.setTransAmount(slip.getAmount());
						transaction.setTransOption("slip");
						transaction.setTransDate(LocalDateTime.now());
						transaction.setTransClosingBalnace(balance);
						transaction.setTransFrom(value);
						transaction.setTransTo(slip.getAccountNum());
						
						slip.setSlipId(Integer.toString(random.nextInt(1000000)).substring(0,4));
						slip.setSlipType(transType);
						
						slipRepository.save(slip);
						transactionRepository.save(transaction);
					}
					else {
						throw new InsufficientBalanceException("Insufficient Balance");
					}
					
				}
				else if(transType.equals("debit"))
				{
						if(account.getAccountBalance()>slip.getAmount() && slip.getAmount() > 0)
						{
							Double balance=account.getAccountBalance()-slip.getAmount();
						    account.setAccountBalance(balance);	
						    account.setLastUpdated(LocalDate.now());
						    try {
								restTemplate.put(new URI(updateAccountUrl), account);
							} catch (RestClientException e) {
								e.printStackTrace();
							} catch (URISyntaxException e) {
								e.printStackTrace();
							}
							
				            Transaction transaction=new Transaction();
							
							transaction.setTransId(Integer.toString(random.nextInt(100000000)).substring(0,4));
							transaction.setTransAccountId(slip.getAccountNum());
							transaction.setTransType("debit");
							transaction.setTransAmount(slip.getAmount());
							transaction.setTransOption("slip");
							transaction.setTransDate(LocalDateTime.now());
							transaction.setTransClosingBalnace(balance);
							transaction.setTransFrom(slip.getAccountNum());
							transaction.setTransTo(value);
							
							slip.setSlipId(Integer.toString(random.nextInt(1000000)).substring(0,4));
							slip.setSlipType(transType);
							
							slipRepository.save(slip);
							transactionRepository.save(transaction);
						}
						else {
								throw new InsufficientBalanceException("Insufficient Balance");
						}
			}
			else {
				throw new InvalidAccountNumberException("Invalid Account Number"); 
			}		
		}
		return slip;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllTransactions
	-Input Parameters         :     -
	-Return Type              :     List of Transactions
	-Throws                   :     -
	-Author                   :     M.Sai, N.Manikanta 
	-Created/Modified Date    :     22-09-2020
	-Description              :    Getting all transaction from Transaction Database 
	*******************************************************************************************************************************/
	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> list = transactionRepository.findAll();
		if(list.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return list;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllTransactionsByAccountNum
	-Input Parameters         :     AccountNumber(String)
	-Return Type              :     List of Transactions
	-Throws                   :     -
	-Author                   :     M.Sai, N.Manikanta 
	-Created/Modified Date    :     22-09-2020
	-Description              :    Getting all transaction from Transaction Database Of Paticular Database
	*******************************************************************************************************************************/
	@Override
	public List<Transaction> getAllTransactionsByAccountNum(String accountNum) {
		List<Transaction> list = transactionRepository.findAllTrasactionsByAccountNum(accountNum);
		if(list.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return list;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllCheques
	-Input Parameters         :     -
	-Return Type              :     List of Cheques
	-Throws                   :     -
	-Author                   :     N.Manikanta 
	-Created/Modified Date    :     22-09-2020
	-Description              :     Getting all Cheques from Cheque Database 
	*******************************************************************************************************************************/
	@Override
	public List<Cheque> getAllCheques() {
		List<Cheque> list=chequeRepository.findAll();
		if(list.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
		return list;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllChequesByAccountNum
	-Input Parameters         :     AccountNumber(String)
	-Return Type              :     List of Cheques
	-Throws                   :     -
	-Author                   :     N.Manikanta 
	-Created/Modified Date    :     22-09-2020
	-Description              :     Getting all Cheques from Cheque Database of Paticular AccountNumber 
	*******************************************************************************************************************************/
	@Override
	public List<Cheque> getAllChequesByAccountNum(String accountNum) {
		List<Cheque> list=chequeRepository.findAllChequesByAccountNum(accountNum);
		if(list.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return list;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllSlips
	-Input Parameters         :     -
	-Return Type              :     List of Slips
	-Throws                   :     -
	-Author                   :     N.Manikanta 
	-Created/Modified Date    :     22-09-2020
	-Description              :     Getting all Cheques from Cheque Database 
	*******************************************************************************************************************************/
	@Override
	public List<Slip> getAllSlips() {
		List<Slip> list=slipRepository.findAll();
		if(list.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return list;
	}

	/*******************************************************************************************************************************
	-Function Name            :     getAllSlipsByAccountNum
	-Input Parameters         :     AccountNumber(String)
	-Return Type              :     List of Slips
	-Throws                   :     -
	-Author                   :     N.Manikanta 
	-Created/Modified Date    :     22-09-2020
	-Description              :     Getting all Slips from Slip Database of Paticular AccountNumber 
	*******************************************************************************************************************************/
	@Override
	public List<Slip> getAllSlipsByAccountNum(String accountNum) {
		List<Slip> list = slipRepository.findAllSlipsByAccountNum(accountNum);
		if(list.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return list;
	}

}
