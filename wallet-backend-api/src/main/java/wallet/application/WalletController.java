package wallet.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import shared.domain.RequestResponse;
import wallet.domain.Movement;
import wallet.domain.Wallet;
import wallet.domain.WalletDTO;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private RestTemplate template;

	@Autowired
	private WalletService walletService;

	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse createWallet(@RequestBody WalletDTO request) {
		Wallet wallet = this.walletService.createNewWallet(request);

		return new RequestResponse(wallet, true);

	}

	@PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse depositMoney(@RequestBody WalletDTO request) {
		List<Movement> movements = this.walletService.deposit(request);

		return new RequestResponse(movements, true);

	}

	@PostMapping(path = "/withdrawals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse withdrawalsMoney(@RequestBody WalletDTO request) {
		List<Movement> movements = this.walletService.withdrawals(request);

		return new RequestResponse(movements, true);

	}

	@GetMapping(path = "/movements{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse getMovements(@PathVariable("id") String id) {
		List<Movement> movements = this.walletService.getMovementsByWallet(id);

		return new RequestResponse(movements, true);

	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestResponse getWallet(@PathVariable("id") String id) {
		Wallet wallet = this.walletService.getWalletById(id);

		return new RequestResponse(wallet, true);

	}

}
