package com.liza.hsimR_backend.service.impl;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.liza.hsimR_backend.dto.TransactionDto;
import com.liza.hsimR_backend.model.Franchise;
import com.liza.hsimR_backend.model.Tour;
import com.liza.hsimR_backend.model.Transaction;
import com.liza.hsimR_backend.model.exception.InsufficientResourceException;
import com.liza.hsimR_backend.repository.FranchiseRepository;
import com.liza.hsimR_backend.repository.TourRepository;
import com.liza.hsimR_backend.repository.TransactionRepository;
import com.liza.hsimR_backend.service.BanqueService;


@Service
public class BanqueServiceImpl implements BanqueService {

	@Autowired
	private FranchiseRepository franchiseRepository;

	@Autowired
	private TourRepository tourRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public TransactionDto creerDepense(Principal principal, TransactionDto transactionDto)
			throws EntityNotFoundException, IllegalArgumentException, InsufficientResourceException {
		
		if (!(transactionDto.getMontant()>0)) {
			throw new IllegalArgumentException("Le montant doit être positif");
		} else if (!StringUtils.hasText(transactionDto.getLibelle())) {
			throw new IllegalArgumentException("Le libellé doit être renseigné");
		}
		
		Franchise sourceF = franchiseRepository.findByNom(principal.getName()).orElseThrow(
				() -> new EntityNotFoundException("la franchise connectée n'a pas été trouvée en base de données"));

		Tour tour = tourRepository.findByActif(true)
				.orElseThrow(() -> new EntityNotFoundException("le tour actif n'a pas été trouvé en bdd"));

		if (sourceF.getArgent() < transactionDto.getMontant()) {
			throw new InsufficientResourceException("Montant supérieur au montant maximum de la franchise");
		}

		Transaction transaction;
		if (transactionDto.getDestinataireF() !=null) {
			Franchise destinataireF = franchiseRepository.findById(transactionDto.getDestinataireF().getId())
					.orElseThrow(() -> new EntityNotFoundException("Le destinataire n'a pas été trouvé en bdd : "
							+ transactionDto.getDestinataireF().getId()));

			// effectuer transaction
			float srcArgent = sourceF.getArgent();
			float destArgent = destinataireF.getArgent();
			sourceF.setArgent(sourceF.getArgent() - transactionDto.getMontant());
			System.out.println(srcArgent + sourceF.getArgent());
			destinataireF.setArgent(destinataireF.getArgent() + transactionDto.getMontant());
			System.out.println(destArgent + destinataireF.getArgent());
			transaction = new Transaction(transactionDto.getMontant(), transactionDto.getLibelle(), tour, sourceF,
					destinataireF);
			try {
				// save
				franchiseRepository.save(sourceF);
				franchiseRepository.save(destinataireF);
				transactionRepository.save(transaction);
			} catch (Exception e) {
				System.out.println("erreur lors de la sauvegarde de la transaction : " + transaction.getLibelle());
				System.out.println(e);
				// resave old
				sourceF.setArgent(srcArgent);
				destinataireF.setArgent(destArgent);
				franchiseRepository.save(sourceF);
				franchiseRepository.save(destinataireF);
				transactionRepository.delete(transaction);
			}
		} else {
			System.out.println("Aucun destinataire pour la transaction : " + transactionDto.getLibelle());

			// effectuer transaction
			float srcArgent = sourceF.getArgent();
			sourceF.setArgent(sourceF.getArgent() - transactionDto.getMontant());
			transaction = new Transaction(transactionDto.getMontant(), transactionDto.getLibelle(), tour, sourceF,
					null);
			try {
				// save
				franchiseRepository.save(sourceF);
				transactionRepository.save(transaction);
			} catch (Exception e) {
				System.out.println("erreur lors de la sauvegarde de la transaction : " + transaction.getLibelle());
				System.out.println(e);
				// resave old
				sourceF.setArgent(srcArgent);
				franchiseRepository.save(sourceF);
				transactionRepository.delete(transaction);
			}
		}


		return mapper.map(transaction, TransactionDto.class);
	}

	@Override
	public List<TransactionDto> historiqueTransaction(Principal principal, String type) {
		Franchise franchise = franchiseRepository.findByNom(principal.getName()).orElseThrow(
				() -> new EntityNotFoundException("la franchise connectée n'a pas été trouvée en base de données"));

		List<Transaction> transactions = new ArrayList<Transaction>();
		
		if(type.equals("depense")) {
			transactions = transactionRepository.findAllBySourceF(franchise);
		}
		if (type.equals("gain")) {
			transactions = transactionRepository.findAllByDestinataireF(franchise);
		}

		// Mapping to DTO
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Type listType = new TypeToken<List<TransactionDto>>() {
		}.getType();

		return mapper.map(transactions, listType);
	}

}
